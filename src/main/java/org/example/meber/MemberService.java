package org.example.meber;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
