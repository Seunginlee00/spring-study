package org.example.meber;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
