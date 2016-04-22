package Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SchedProcessor {

    private DBManager db;
    private Object[][] courses;
    private Object[][] rooms;
    private int score, eseatscore, bpref2score, bpref3score, bprefnoscore;
    private final double B_PREF_SCORE_WT = 1000;
    private final int E_SEAT_SCORE_WT = 10;
    private int[][] monTT, tueTT, wedTT, thuTT, friTT;

    public static void main(String[] args) throws SQLException {

        SchedProcessor test = new SchedProcessor();

        test.process();

        //System.out.println(test.monTT[0][3]);

    }

    public SchedProcessor() throws SQLException {
        db = new DBManager();
        courses = db.getCourseTable();
        rooms = db.getRoomTable();
        score = 1;
        eseatscore = 0;
        bpref2score = 0;
        bpref3score = 0;
        bprefnoscore = 0;
        monTT = new int[rooms.length][9];
        tueTT = new int[rooms.length][6];
        wedTT = new int[rooms.length][9];
        thuTT = new int[rooms.length][6];
        friTT = new int[rooms.length][9];

    }

    public void process() {

        //production of course permutations; Loop this num_courses^num_courses or until perfect schedule is found
        //for (int i = 0; (i < Math.pow(courses.length, courses.length)) || (score == 0); i++) {
        //score = 0;
        //System.out.println(rooms[11][4]);
        Collections.shuffle(Arrays.asList(courses));
        //schedule all courses
        
        //loop courses table
        for (int j = 0; j < courses.length; j++) {
            
            //loop rooms table
            for (int k = 0; k < rooms.length; k++) {

                //System.out.println(courses[j][16] + " " + rooms[k][4]);
   
               
                //int ggg = (Integer.valueOf((String)courses[j][16]));
               // int kkk = (Integer.valueOf((String)rooms[k][4]));
                
                //if pref1 matches the building current room is in
                if (courses[j][16].toString().equals((rooms[k][4]).toString())){
                    System.out.println("found preferred building");
                    //find proper RoomType in building
                    if(courses[j][3].toString().equals((rooms[k][1]).toString())){
                        System.out.println("found proper RoomType");
                        //find room with capacity
                        if(Integer.parseInt((courses[j][4].toString())) <= Integer.parseInt((rooms[k][2].toString()))){
                            System.out.println(courses[j][4] + "   " + rooms[k][2]);
                            System.out.println("found room with capacity");
                            
                        }
                    }
                }

                /**
                 * greedy algorithm here: get building preference1 for current
                 * course find closest fit room try to schedule at first
                 * available time slot if no time, move to next biggest room in
                 * building if no room in building available with time move to
                 * buildpref2 repeat when room found, schedule and update score
                 */
            }
        }
    }

}
