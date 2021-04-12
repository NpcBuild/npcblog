package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Comment;
import com.example.vo.CommentVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author npcblog
 * @since 2021-04-10
 */
public interface CommentService extends IService<Comment> {
    IPage<CommentVo> paing(Page page, Long postId, Long userId, String order);
}
