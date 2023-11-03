package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        // create two Job objects using the empty constructor
        Job job1 = new Job();
        Job job2 = new Job();

        //verify that the IDs of the two objects are distinct
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {

        // declare and initialize new job object
       Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //test the class and values of each field is correct
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());

        //Test for class type

        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {

        // create identical jobs except ID
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //Check that they are not equal
        assertFalse(job1.equals(job2));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {


        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //call toString method
        String jobString = job.toString();

        //check for blank line before and after job information
        assertTrue(jobString.startsWith("\n"));
        assertTrue(jobString.endsWith("\n"));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //call method
        String jobString = job.toString();

        //make expected response with label, data, and line separator
            String expectedString = "\n" +
                        "ID: " + job.getId() + "\n" +
                        "Name: " + job.getName() +"\n" +
                        "Employer: " + job.getEmployer().getValue() + "\n" +
                        "Location: " + job.getLocation().getValue() +"\n" +
                        "Position Type: " + job.getPositionType().getValue() +"\n" +
                        "Core Competency: " + job.getCoreCompetency().getValue() +"\n";

            //check that expected equal to actual
            assertEquals(expectedString, jobString);


    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        //call method



        String expectedString = "\nID: " + job.getId() + System.lineSeparator() +
                "Name: Data not available" + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: Data not available" + System.lineSeparator();

        //check that expected equal to actual

        String jobString = job.toString();
        assertEquals(expectedString, jobString);



    }


    }



