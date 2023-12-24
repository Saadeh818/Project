package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public
class Appointment {
    private static final Logger  LOGGER     = Logger.getLogger ( Appointment.class.getName ( ) );
    protected static        boolean addSuccess;
    String             user;
    String             requestID;
    Date               appointmentDate;
    SimpleDateFormat[] simpleDateFormats = {
            new SimpleDateFormat ( "dd/MM/yyyy" ) ,
            new SimpleDateFormat ( "dd/M/yyyy" ) ,
            new SimpleDateFormat ( "d/MM/yyyy" ) ,
            new SimpleDateFormat ( "d/M/yyyy" )
    };


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
                addSuccess = false;
            }
        }
    }

    private
    void addAppointmentToTheFile ( Appointment appointment ) {
        try {
            File           file             = new File ( "src/Appointments" );
            BufferedWriter bufferedWriter   = new BufferedWriter ( new FileWriter ( file , true ) );
            String         appointmentToAdd = appointment.requestID + ", " + appointment.user + ", " + appointment.appointmentDate.toString ( );
            bufferedWriter.newLine ( );
            bufferedWriter.write ( appointmentToAdd );
            bufferedWriter.close ( );
        }
        catch ( IOException e ) {
            LOGGER.log(java.util.logging.Level.SEVERE,"An Error Occurred "+ e);
        }

    }
}
