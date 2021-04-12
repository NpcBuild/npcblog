package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Post;
import com.example.vo.PostVo;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author npcblog
 * @since 2021-04-10
 */
public interface PostService extends IService<Post> {

    IPage paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order);

    PostVo selectOnePost(QueryWrapper<Post> wrapper);

    void initWeekRank();

    void incrCommentCountAndUnionForWeekRank(Long postId,boolean isIncr);

    void putViewCount(PostVo vo);
}
