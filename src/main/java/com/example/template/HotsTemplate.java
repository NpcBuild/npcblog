package com.example.template;

import com.example.common.templates.DirectiveHandler;
import com.example.common.templates.TemplateDirective;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 本周热议
 */
@Component
public class HotsTemplate extends TemplateDirective {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String getName() {
        return "hots";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        String weekRankKey = "week:rank";

        Set<ZSetOperations.TypedTuple> typedTuples = redisUtil.getZSetRank(weekRankKey, 0, 6);

        List<Map> hotPosts = new ArrayList<>();

        for (ZSetOperations.TypedTuple typedTuple : typedTuples) {
            Map<String, Object> map = new HashMap<>();

            Object value = typedTuple.getValue(); // post的id
//原来是这里的post后多写了个：
            String postKey = "rank:post" + value;

            map.put("id", value);
//不知道是哪里的错误，获取不到title的值
//redisUtil.hget(postKey,"post:title")为空！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
            map.put("title", redisUtil.hget(postKey,"post:title"));
            map.put("commentCount", typedTuple.getScore());

            hotPosts.add(map);
        }

        handler.put(RESULTS, hotPosts).render();

    }
}
