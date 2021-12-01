package com.jaskiratmann;

public class Librarian extends Account {

    public boolean unblockMember(Member member) {
        if (member.accountStatus != AccountStatus.CANCELLED || member.accountStatus != AccountStatus.CLOSED) {
            member.accountStatus = AccountStatus.ACTIVE;
            return true;
        } else {
            return false;
        }
    }

    public boolean blockMember(Member member) {
        if (member.accountStatus != AccountStatus.CANCELLED || member.accountStatus != AccountStatus.CLOSED) {
            member.accountStatus = AccountStatus.BLACKLISTED;
            return true;
        } else {
            return false;
        }
    }
}
