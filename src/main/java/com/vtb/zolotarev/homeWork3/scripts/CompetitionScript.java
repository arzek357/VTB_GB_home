package com.vtb.zolotarev.homeWork3.scripts;

import com.vtb.zolotarev.homeWork3.interfaces.Actionable;
import com.vtb.zolotarev.homeWork3.interfaces.GradeAbility;

public class CompetitionScript {
    public static void beginningOfCompetitions(Actionable[] participants, GradeAbility[] obstacleCourse) {
        for (Actionable participant : participants) {
            participant.startDistance();
            for (GradeAbility obstacle : obstacleCourse) {
                obstacle.actionChoose(participant);
                if (!participant.isSuccess()) {
                    break;
                }
            }
            if (participant.isSuccess()) {
                System.out.println("Участник успешно прошел полосу препятствий!\n");
            } else {
                System.out.println("Участник сходит с дистанции!\n");
            }
        }
    }
}
