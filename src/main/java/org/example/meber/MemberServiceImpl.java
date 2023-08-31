package org.example.meber;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;  // 구체적인건 config 가 ..

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member); // 오버라이드 된게 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
