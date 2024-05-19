package study.likelionbeweekly.week2.manual.member;

public class MemberServicePureJavaImpl implements MemberService{

    private MemberRepository memberRepository;

    public MemberServicePureJavaImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }
}
