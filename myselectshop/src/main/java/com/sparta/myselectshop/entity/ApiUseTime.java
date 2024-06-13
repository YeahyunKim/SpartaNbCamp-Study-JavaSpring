package com.sparta.myselectshop.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//회원별로 누적 Api 사용시간을 저장해야하기 때문에 생성한 Entity. Entity를 생성한 다음에는 Repository를 생성해야하니, ApiUserTimeRepository를 생성하자
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "api_use_time")
public class ApiUseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Long totalTime; //누적 전체 시간

    public ApiUseTime(User user, Long totalTime) {
        this.user = user;
        this.totalTime = totalTime;
    }

    public void addUseTime(long useTime) { // 이 메서드를 통해 누적 시간 증가
        this.totalTime += useTime;
    }
}