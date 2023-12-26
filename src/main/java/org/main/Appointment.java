package org.main;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public
class Appointment {
    private static final Logger LOGGER = Logger.getLogger ( Appointment.class.getName ( ) );
    public static final String SRC_APPOINTMENTS = "src/Appointments";
    public static boolean appointmentsDisplayed;
    public static boolean addSuccess = false;
    public static boolean userHasAppointments;
    String             user;
    String             requestID;
    Date               appointmentDate;
    SimpleDateFormat[] simpleDateFormats = {
            new SimpleDateFormat ( "dd/MM/yyyy" ) ,
            new SimpleDateFormat ( "dd/M/yyyy" ) ,
            new SimpleDateFormat ( "d/MM/yyyy" ) ,
            new SimpleDateFormat ( "d/M/yyyy" )
    };

    public static
    void viewAppointments ( String mail ) {
        File file = new File ( SRC_APPOINTMENTS );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                String   appointment;
                String[] data;
                while ( (appointment = bufferedReader.readLine ( )) != null ) {
                    data = appointment.split ( "," );
                    if (data[1].equals ( mail )){
                        LOGGER.info ( appointment );
                        userHasAppointments= true;
                    }
                }
                if(!userHasAppointments){
                    LOGGER.info ( "No Appointments Yet" );
                }
            }
        }
        catch ( IOException e ) {
            userHasAppointments= false;
            Users.printException ( e.getMessage () );
        }
    }

    public static
    void viewAllAppointments ( ) {
        File file = new File ( SRC_APPOINTMENTS );
        try {
            try (BufferedReader bufferedReader = new BufferedReader ( new FileReader ( file ) )) {
                String   appointment;
                while ( (appointment = bufferedReader.readLine ( )) != null ) {
                    LOGGER.info ( appointment );
                        appointmentsDisplayed= true;
                }
                if(!appointmentsDisplayed){
                    LOGGER.info ( "No Appointments Yet" );
                }
            }
        }
        catch ( IOException e ) {
            appointmentsDisplayed= false;
            Users.printException ( e.getMessage () );
        }
    }


    public
    boolean checkDate ( String date ) {
        for ( SimpleDateFormat simpleDateFormat : simpleDateFormats ) {
            simpleDateFormat.setLenient ( false );
            try {
                Date inputDate = simpleDateFormat.parse ( date );
                checkIfDateValid ( inputDate );
                Date currentDate = new Date ( );
                if ( ! inputDate.before ( currentDate ) )
                    return true;
                else {
                    LOGGER.info ( "You cant make an appointment in passed days :/" );
                    addSuccess = false;
                    return false;
                }
            }
            catch ( ParseException | IllegalArgumentException e ) {
                LOGGER.info ( "Date Format Wrong or Try another date ;)" );
                addSuccess = false;
                return false;
            }
        }
        return false;
    }

    private
    void checkIfDateValid ( Date inputDate ) {
        Calendar calendar = Calendar.getInstance ( );
        calendar.setTime ( inputDate );
        int day   = calendar.get ( Calendar.DAY_OF_MONTH );
        int month = calendar.get ( Calendar.MONTH ) + 1;
        int year  = calendar.get ( Calendar.YEAR );

        if ( month > 12 ) {
            throw new IllegalArgumentException ( "Invalid month in the date." );
        }

        int monthDays = getDaysInMonth ( month , year );
        if ( day > monthDays ) {
            throw new IllegalArgumentException ( "Invalid day in this month." );
        }
    }

    private
    int getDaysInMonth ( int month , int year ) {
        return switch (month) {
            case 2 -> {
                if ( (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ) yield 29;
                yield 28;
            }
            case 4 , 6 , 9 , 11 -> 30;
            default -> 31;
        };
    }

    public
    void addNewAppointment ( String date , String requestID , String userRequested ) {
        for ( SimpleDateFormat simpleDateFormat : simpleDateFormats ) {
            simpleDateFormat.setLenient ( false );
            try {
                appointmentDate = simpleDateFormat.parse ( date );
                this.user       = userRequested;
                this.requestID  = requestID;
                addAppointmentToTheFile ( this );
                LOGGER.info ( "Appointment added successfully." );
                addSuccess = true;
                return;
            }
            catch ( ParseException e ) {
                String s = e.getMessage ();
                LOGGER.info ( s );
                addSuccess = false;
            }
        }
    }

    private
    void addAppointmentToTheFile ( Appointment appointment ) {
        try {
            File           file             = new File ( SRC_APPOINTMENTS );
            try (BufferedWriter bufferedWriter = new BufferedWriter ( new FileWriter ( file , true ) )) {
                String appointmentToAdd = appointment.requestID + "," + appointment.user + "," + appointment.appointmentDate.toString ( );
                bufferedWriter.newLine ( );
                bufferedWriter.write ( appointmentToAdd );
            }
        }
        catch ( IOException e ) {
            Users.printException ( e.getMessage () );
        }
    }
}
