/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 * @author gebruiker-pc
 */
public class Colony
{

    private final int year;
    private final Queen queen;
    private Colony parentColony;

    private final ArrayList<Bee> bees;
    private ArrayList<Colony> children;

    public int getYear()
    {
        return year;
    }

    public Queen getQueen()
    {
        return queen;
    }

    public ArrayList<Bee> getBees()
    {
        return (ArrayList<Bee>) Collections.unmodifiableList(bees);
    }

    public Colony getParentColony()
    {
        return parentColony;
    }

    public void setParentColony(Colony parentColony)
    {
        this.parentColony = parentColony;
    }

    public void addChildColony(Colony colony)
    {
        if (!this.children.contains(colony))
        {
            this.children.add(colony);
        }
    }

    public Iterator<Colony> getChildColonies()
    {
        return this.children.iterator();
    }

    public Colony(int year, Queen queen, ArrayList<Bee> bees)
    {
        this.year = year;
        this.queen = queen;
        this.bees = bees;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        return String.format("Generatie: %s%nYear: %s", Integer.toString(this.year - 2015), Integer.toString(this.year));
    }

    public final static Comparator<Colony> COMPARE_BY_YEAR = (Colony one, Colony other) -> Integer.compare(one.year, other.year);

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 53 * hash + this.year;
        hash = 53 * hash + Objects.hashCode(this.queen);
        hash = 53 * hash + Objects.hashCode(this.parentColony);
        hash = 53 * hash + Objects.hashCode(this.bees);
        hash = 53 * hash + Objects.hashCode(this.children);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Colony other = (Colony) obj;
        if (this.year != other.year)
        {
            return false;
        }
        if (!this.queen.equals(other.queen))
        {
            return false;
        }
        if (!Objects.equals(this.parentColony, other.parentColony))
        {
            return false;
        }
        return true;
    }

    public int getBeeCount()
    {
        return this.bees.size();
    }

    public double getAveragePrimaryFertility()
    {
        int primaryFertilityCumulative = 0;

        for (Bee bee : this.bees)
        {
            primaryFertilityCumulative += bee.getPrimaryFertility();
        }

        return (double)(primaryFertilityCumulative / this.getBeeCount());
    }

    public double getAveragePrimaryLifeSpan()
    {
        double primaryLifeSpanCumulative = 0;

        for (Bee bee : this.bees)
        {
            primaryLifeSpanCumulative += bee.getPrimaryLifespan();
        }

        return primaryLifeSpanCumulative / this.getBeeCount();
    }

    public double getAveragePrimaryPollination()
    {
        double primaryLifeSpanCumulative = 0;

        for (Bee bee : this.bees)
        {
            primaryLifeSpanCumulative += bee.getPrimaryPollination();
        }

        return primaryLifeSpanCumulative / this.getBeeCount();
    }

    public String getAveragePrimarySpecies()
    {
        Map<String, Integer> primarySpeciesCounts = new HashMap<>();

        for (Bee bee : this.bees)
        {
            if (!primarySpeciesCounts.containsKey(bee.getPrimarySpecies()))
            {
                primarySpeciesCounts.put(bee.getPrimarySpecies(), 0);
            }

            int currentCount = primarySpeciesCounts.get(bee.getPrimarySpecies());
            primarySpeciesCounts.replace(bee.getPrimarySpecies(), currentCount + 1);
        }

        int maxValueInMap = (Collections.max(primarySpeciesCounts.values()));
        for (Entry<String, Integer> entry : primarySpeciesCounts.entrySet())
        {
            if (entry.getValue() == maxValueInMap)
            {
                return entry.getKey();
            }
        }

        return null;
    }

    public double getAverageSecondaryFertility()
    {
        int secondaryFertilityCumulative = 0;

        for (Bee bee : this.bees)
        {
            secondaryFertilityCumulative += bee.getSecondaryFertility();
        }

        return (double)(secondaryFertilityCumulative / this.getBeeCount());
    }

    public double getAverageSecondaryLifeSpan()
    {
        double secondaryLifeSpanCumulative = 0;

        for (Bee bee : this.bees)
        {
            secondaryLifeSpanCumulative += bee.getSecondaryLifespan();
        }

        return secondaryLifeSpanCumulative / this.getBeeCount();
    }

    public double getAverageSecondaryPollination()
    {
        double secondaryPollinationCumulative = 0;

        for (Bee bee : this.bees)
        {
            secondaryPollinationCumulative += bee.getSecondaryPollination();
        }

        return secondaryPollinationCumulative / this.getBeeCount();
    }

    public String getAverageSecondarySpecies()
    {
        Map<String, Integer> secondarySpeciesCounts = new HashMap<>();

        for (Bee bee : this.bees)
        {
            if (!secondarySpeciesCounts.containsKey(bee.getSecondarySpecies()))
            {
                secondarySpeciesCounts.put(bee.getSecondarySpecies(), 0);
            }

            int currentCount = secondarySpeciesCounts.get(bee.getSecondarySpecies());
            secondarySpeciesCounts.replace(bee.getSecondarySpecies(), currentCount + 1);
        }

        int maxValueInMap = (Collections.max(secondarySpeciesCounts.values()));
        for (Entry<String, Integer> entry : secondarySpeciesCounts.entrySet())
        {
            if (entry.getValue() == maxValueInMap)
            {
                return entry.getKey();
            }
        }

        return null;
    }
}
