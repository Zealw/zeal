package com.zeal.service;

import com.zeal.dto.MatchDTO;
import com.zeal.entity.User;
import com.zeal.util.R;

/**
 * (Sutdent)表服务接口
 *
 * @author makejava
 * @since 2023-06-15 15:38:02
 */
public interface UserService {

    R updateMatchInformation(MatchDTO matchDTO);
    R add(User user);

    R update(User user);

    R info(Long userId);
}

