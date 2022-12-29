package GDSC.Backend4th.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(false)
    public void InsertMember() {

        //given
        memberRepository.save(Member.builder()
                .id(1L)
                .name("testName")
                .build());

        //when
        List<Member> all = memberRepository.findAll();

        //then
        assertThat(all.get(0).getId()).isEqualTo(1);
        assertThat(all.get(0).getName()).isEqualTo("testName");

    }

}
