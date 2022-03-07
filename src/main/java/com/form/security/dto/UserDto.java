package com.form.security.dto;

import com.form.security.domain.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();
    }

    @Builder
    public UserDto(Long id, String username, String password, String nickname, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
