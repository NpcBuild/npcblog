package com.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author npcblog
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserCollection extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long postId;

    private Long postUserId;


}
