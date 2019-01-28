package com.github.scotts.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.avro.reflect.ReflectDatumWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReflectedClimberExample {

    public static void main(String[] args) {

        //let's reflect this class to print out a starter schema
        Schema schema = ReflectData.get().getSchema(ReflectedRecordClimber.class);
        System.out.println("schema = " + schema.toString(true));

        //let's save ths schema to a file for editing and use later
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("climbinggym.avsc"));
            writer.append(schema.toString(true));
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        //let's use reflection on this class to create an Avro object
        try {
            File file = new File("climbinggym.avro");
            DatumWriter<ReflectedRecordClimber> writer = new ReflectDatumWriter<>(ReflectedRecordClimber.class);
            DataFileWriter<ReflectedRecordClimber> out = new DataFileWriter<>(writer)
                    .setCodec(CodecFactory.deflateCodec(9))
                    .create(schema, file);
            ReflectedRecordClimber reflectedRecordClimber = new ReflectedRecordClimber("Inner Peaks");
            reflectedRecordClimber.setGymNickName("Inner Peaks or South End");
            reflectedRecordClimber.setGymLocation("Charlotte, NC");
            reflectedRecordClimber.setOffersBouldering(true);
            reflectedRecordClimber.setOffersLeadClimbing(true);
            reflectedRecordClimber.setOffersSpeedClimbing(true);
            reflectedRecordClimber.setOffersTopRopeClimbing(true);
            out.append(reflectedRecordClimber);
            out.close();
            System.out.println("Created file climbinggym.avro");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //let's read that Avro object
        try {
            File file = new File("climbinggym.avro");
            DatumReader<ReflectedRecordClimber> reader = new ReflectDatumReader<>(ReflectedRecordClimber.class);
            DataFileReader<ReflectedRecordClimber> in = new DataFileReader<>(file, reader);
            for (ReflectedRecordClimber readClimbingGym : in) {
                System.out.println("Name of Climbing Gym: " + readClimbingGym.getGymName());
                System.out.println("Nick Name of Climbing Gym: " + readClimbingGym.getGymNickName());
                System.out.println("Location of the Climbing Gym: " + readClimbingGym.getGymLocation());
                System.out.println("Gym offers top rope climbing?: " + readClimbingGym.isOffersTopRopeClimbing());
                System.out.println("Gym offers lead climbing: " + readClimbingGym.isOffersLeadClimbing());
                System.out.println("Gym offers bouldering: " + readClimbingGym.isOffersBouldering());
                System.out.println("Gym offers speed climbing: " + readClimbingGym.isOffersSpeedClimbing());            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
