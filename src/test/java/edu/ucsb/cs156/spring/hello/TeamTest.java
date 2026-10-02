package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_sameObject() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_correct_differentClass() {
        assertEquals(false, team.equals("hello"));
    }

    @Test
    public void equals_returns_correct_sameName_sameMembers() {
        Team a = new Team();
        a.addMember("Tara");
        Team b = new Team();
        b.addMember("Tara");
        assertEquals(false, a == b);
        assertEquals(true, a.equals(b));
    }

    @Test
    public void equals_returns_correct_sameName_differentMembers() {
        Team a = new Team();
        a.addMember("Tara");
        Team b = new Team();
        b.addMember("Noah");
        assertEquals(false, a.equals(b));
    }

    @Test
    public void equals_returns_correct_differentName_sameMembers(){
        Team a = new Team("team-a");
        Team b = new Team("team-b");
        assertEquals(false, a.equals(b));
    }

    @Test
    public void equals_returns_correct_differentName_differentMembers() {
        Team a = new Team("team-a");
        a.addMember("Tara");
        Team b = new Team("team-b");
        b.addMember("Noah");
        assertEquals(false, a.equals(b));
    }

    @Test
    public void hashcode_value_returns_equal() {
        Team t1 = new Team("foo");
        t1.addMember("Tara");
        Team t2 = new Team("foo");
        t2.addMember("Tara");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashcode_value_equals_returns_correct() {
        Team t1 = new Team();

        int result = t1.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }



}
