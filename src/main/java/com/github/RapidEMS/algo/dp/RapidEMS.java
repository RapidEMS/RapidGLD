package com.github.RapidEMS.algo.dp;

import com.github.RapidEMS.infra.*;

public class RapidEMS {
    public static boolean useRapidEMS;

    /**
     * Returns the {@link Drivelane} that is left of the given lane.
     * @param lane The {@link Drivelane}.
     * @return The {@link Drivelane} that is to the left of the given lane.
     */
    public static Drivelane getLeftLane(Drivelane lane) {
        Road road = lane.getRoad();
        Drivelane[] lanes = road.getAlphaLanes();

        // Finding the index of the lane
        int index = -1;
        for (int i = 0; i < lanes.length; i++)
            if (lanes[i] == lane) index = i;

        if (index == -1) {
            lanes = road.getBetaLanes();
            for (int i=0; i<lanes.length; i++) if (lanes[i]==lane) index=i;
        }

        Drivelane leftDL = null;

        if (index>0) leftDL = lanes[index-1];

        return leftDL;
    }

    /**
     * Returns the {@link Drivelane} that is to the right of the given lane.
     * @param lane The {@link Drivelane}.
     * @return The {@link Drivelane} that is to the right of the given lane.
     */
    public static Drivelane getRightLane(Drivelane lane) {
        Road road = lane.getRoad();
        Drivelane[] lanes = road.getAlphaLanes();

        // Finding the index of the lane
        int index = -1;
        for (int i = 0; i < lanes.length; i++)
            if (lanes[i] == lane) index = i;

        if (index == -1) {
            lanes = road.getBetaLanes();
            for (int i=0; i<lanes.length; i++) if (lanes[i]==lane) index=i;
        }

        Drivelane rightDL = null;

        if (index<lanes.length-1) rightDL= lanes[index+1];

        return rightDL;
    }

    /**
     * Checks if a {@link Roaduser} is able to enter another {@link Drivelane}.
     * @param testLane The {@link Drivelane} that the {@link Roaduser} is attempting to enter.
     * @param origLane The {@link Drivelane} that the {@link Roaduser} is currently on.
     * @param ru The {@link Roaduser}.
     * @return True if the {@link Roaduser} is able to switch lanes, false otherwise.
     */
    private static boolean checkDrivelane(Drivelane testLane, Drivelane origLane, Roaduser ru) {
        if (testLane==null) return false;

        // Check whether this roaduser may enter that road, i.e. the types should be correct.
        if ((testLane. getType() & ru.getType())==0) return false;

        // Is the position free?
        if (!testLane.isPosFree(ru.getPosition(),ru.getLength())) return false;

        // Is the next position free?, otherwise it is useless...
        if (ru.getPosition()==0) return false;
        if (testLane.getNumRoadusersWaiting()>0)
            if (!testLane.isPosFree(ru.getPosition()-1,1)) return false;

        return true;
    }

    public static boolean moveLeft(Drivelane leftLane, Drivelane lane, Roaduser ru) {
        // The roaduser cannot move into the left lane
        if (!checkDrivelane(leftLane, lane, ru)) {
            //System.out.println("Ambulance cannot switch lanes");
            return false;
        }

        try
        {
            int ru_pos = ru.getPosition() - 1;
            leftLane.addRoaduser(ru, ru_pos);
            ru.setPosition(ru_pos);
        }
        catch (InfraException e)
        {
            System.out.println(String.valueOf(e));
            e.printStackTrace();
        }
        //System.out.println("Ambulance is am going left...");
        return true;
    }

    public static boolean moveRight(Drivelane rightLane, Drivelane lane, Roaduser ru) {
        // The roaduser cannot move into the left lane
        if (!checkDrivelane(rightLane, lane, ru)) return false;

        try
        {
            int ru_pos = ru.getPosition() - 1;
            rightLane.addRoaduser(ru, ru_pos);
            ru.setPosition(ru_pos);
        }
        catch (InfraException e)
        {
            System.out.println(String.valueOf(e));
            e.printStackTrace();
        }
        //System.out.println("I am " + ru.getName() + ", I am going right...");
        return true;
    }

}