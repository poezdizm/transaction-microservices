package ru.poezdizm.trms.userservice.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.poezdizm.trms.userservice.entity.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@RequiredArgsConstructor
class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Sql("populate_users.sql")
    void afterPopulation_findsUser() {
        Optional<User> user = userRepository.findUserByName("test_user");
        assertThat(user).isPresent();
    }

    @Test
    @Sql("populate_all.sql")
    void afterFullPopulation_findsUserWallets() {
        User user = userRepository.findUserByName("test_user").orElse(null);
        assertThat(user).isNotNull();
        assertThat(user.getWallets()).isNotEmpty();
    }

}
