package study.likelionBEweekly.week2.manual.member;

public interface MemberService {
    void join(Member member);
    Member findById(Long id);
}
