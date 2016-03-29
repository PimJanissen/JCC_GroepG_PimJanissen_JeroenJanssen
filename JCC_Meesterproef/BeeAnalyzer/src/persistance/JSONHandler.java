/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import business.Bee;
import business.Colony;
import business.Female;
import business.Male;
import business.Queen;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gebruiker-pc
 */
public class JSONHandler
{

    public static ArrayList<Colony> loadColonies(String filePath) throws IOException
    {
        ArrayList<Colony> colonies = new ArrayList<>();

        try (Reader reader = new InputStreamReader(new FileInputStream(filePath)))
        {
            Gson gson = new GsonBuilder().create();
            JsonReader jsonReader = gson.newJsonReader(reader);

            jsonReader.beginArray();
            while (jsonReader.hasNext())
            {
                colonies.add(parseColony(jsonReader, colonies));
            }
            jsonReader.endArray();

            return colonies;
        }
    }

    private static Bee parseUnspecifiedBee(JsonReader jsonReader) throws IOException
    {
        int primaryFertility = 0;
        double primaryLifespan = 0;
        double primaryPollination = 0;
        String primarySpecies = null;
        double primaryWorkspeed = 0;
        int secondaryFertility = 0;
        double secondaryLifespan = 0;
        double secondaryPollination = 0;
        String secondarySpecies = null;
        double secondaryWorkspeed = 0;

        jsonReader.beginObject();
        while (jsonReader.hasNext())
        {
            switch (jsonReader.nextName())
            {
                case "primaryFertility":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryFertility = jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primaryLifespan":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryLifespan = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primaryPollination":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryPollination = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primarySpecies":
                    primarySpecies = jsonReader.nextString();
                    break;
                case "primaryWorkspeed":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryWorkspeed = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryFertility":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryFertility = jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryLifespan":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryLifespan = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryPollination":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryPollination = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondarySpecies":
                    secondarySpecies = jsonReader.nextString();
                    break;
                case "secondaryWorkspeed":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryWorkspeed = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();

        Random random = new Random();

        if (random.nextInt(50) == 0)
        {
            return new Male(primaryFertility, primaryLifespan, primaryPollination, primarySpecies, primaryWorkspeed, secondaryFertility, secondaryLifespan, secondaryPollination, secondarySpecies, secondaryWorkspeed);
        }

        return new Female(primaryFertility, primaryLifespan, primaryPollination, primarySpecies, primaryWorkspeed, secondaryFertility, secondaryLifespan, secondaryPollination, secondarySpecies, secondaryWorkspeed);
    }

    private static Male parseDrone(JsonReader jsonReader) throws IOException
    {
        int primaryFertility = 0;
        double primaryLifespan = 0;
        double primaryPollination = 0;
        String primarySpecies = null;
        double primaryWorkspeed = 0;
        int secondaryFertility = 0;
        double secondaryLifespan = 0;
        double secondaryPollination = 0;
        String secondarySpecies = null;
        double secondaryWorkspeed = 0;

        jsonReader.beginObject();
        while (jsonReader.hasNext())
        {
            switch (jsonReader.nextName())
            {
                case "primaryFertility":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryFertility = jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primaryLifespan":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryLifespan = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primaryPollination":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryPollination = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primarySpecies":
                    primarySpecies = jsonReader.nextString();
                    break;
                case "primaryWorkspeed":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryWorkspeed = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryFertility":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryFertility = jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryLifespan":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryLifespan = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryPollination":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryPollination = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondarySpecies":
                    secondarySpecies = jsonReader.nextString();
                    break;
                case "secondaryWorkspeed":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryWorkspeed = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();

        return new Male(primaryFertility, primaryLifespan, primaryPollination, primarySpecies, primaryWorkspeed, secondaryFertility, secondaryLifespan, secondaryPollination, secondarySpecies, secondaryWorkspeed);
    }

    private static Female parsePrincess(JsonReader jsonReader) throws IOException
    {
        int primaryFertility = 0;
        double primaryLifespan = 0;
        double primaryPollination = 0;
        String primarySpecies = null;
        double primaryWorkspeed = 0;
        int secondaryFertility = 0;
        double secondaryLifespan = 0;
        double secondaryPollination = 0;
        String secondarySpecies = null;
        double secondaryWorkspeed = 0;

        jsonReader.beginObject();
        while (jsonReader.hasNext())
        {
            switch (jsonReader.nextName())
            {
                case "primaryFertility":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryFertility = jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primaryLifespan":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryLifespan = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primaryPollination":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryPollination = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primarySpecies":
                    primarySpecies = jsonReader.nextString();
                    break;
                case "primaryWorkspeed":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryWorkspeed = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryFertility":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryFertility = jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryLifespan":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryLifespan = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryPollination":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryPollination = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondarySpecies":
                    secondarySpecies = jsonReader.nextString();
                    break;
                case "secondaryWorkspeed":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryWorkspeed = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();

        return new Female(primaryFertility, primaryLifespan, primaryPollination, primarySpecies, primaryWorkspeed, secondaryFertility, secondaryLifespan, secondaryPollination, secondarySpecies, secondaryWorkspeed);
    }

    private static Queen parseQueen(JsonReader jsonReader) throws IOException
    {
        int primaryFertility = 0;
        double primaryLifespan = 0;
        double primaryPollination = 0;
        String primarySpecies = null;
        double primaryWorkspeed = 0;
        int secondaryFertility = 0;
        double secondaryLifespan = 0;
        double secondaryPollination = 0;
        String secondarySpecies = null;
        double secondaryWorkspeed = 0;
        Female princess = null;
        Male drone = null;

        jsonReader.beginObject();
        while (jsonReader.hasNext())
        {
            switch (jsonReader.nextName())
            {
                case "drone":
                    drone = parseDrone(jsonReader);
                    break;
                case "princess":
                    princess = parsePrincess(jsonReader);
                    break;
                case "primaryFertility":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryFertility = jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primaryLifespan":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryLifespan = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primaryPollination":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryPollination = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "primarySpecies":
                    primarySpecies = jsonReader.nextString();
                    break;
                case "primaryWorkspeed":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                primaryWorkspeed = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryFertility":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryFertility = jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryLifespan":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryLifespan = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondaryPollination":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryPollination = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "secondarySpecies":
                    secondarySpecies = jsonReader.nextString();
                    break;
                case "secondaryWorkspeed":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext())
                    {
                        switch (jsonReader.nextName())
                        {
                            case "modifier":
                                secondaryWorkspeed = jsonReader.nextDouble();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();

        Queen newQueen = new Queen(primaryFertility, primaryLifespan, primaryPollination, primarySpecies, primaryWorkspeed, secondaryFertility, secondaryLifespan, secondaryPollination, secondarySpecies, secondaryWorkspeed);
        newQueen.setPrincess(princess);
        newQueen.setDrone(drone);

        return newQueen;
    }

    private static Colony parseColony(JsonReader jsonReader, ArrayList<Colony> colonies) throws IOException
    {

        int year = 0;
        Queen queen = null;
        ArrayList<Bee> bees = new ArrayList<>();
        Colony parentColony = null;

        jsonReader.beginObject();
        while (jsonReader.hasNext())
        {
            switch (jsonReader.nextName())
            {
                case "year":
                    year = jsonReader.nextInt();
                    break;
                case "queen":
                    queen = parseQueen(jsonReader);
                    break;
                case "parentColony":
                    parentColony = parseColony(jsonReader, colonies);
                    for (Colony colony : colonies)
                    {
                        if (colony.equals(parentColony))
                        {
                            parentColony = colony;
                        }
                    }

                    break;
                case "bees":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext())
                    {
                        bees.add(parseUnspecifiedBee(jsonReader));
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();

        Colony colony = new Colony(year, queen, bees);

        if (parentColony != null)
        {
            colony.setParentColony(parentColony);
            parentColony.addChildColony(colony);
        }
        
        return colony;
    }
}
