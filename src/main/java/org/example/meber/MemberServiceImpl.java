package org.example.meber;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member); // 오버라이드 된게 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
