package com.company;

import com.company.organella.impl.*;

public class Main {

    public static void main(String[] args) {
	    AnimalCellBuilder animalCellBuilder = new AnimalCellBuilder();
	    PlantCellBuilder plantCellBuilder = new PlantCellBuilder();

	    Cell animalCell = animalCellBuilder.addCore(new Core())
                                            .addCellMembrane(new CellMembrane())
                                            .addVacuoles(new Vacuoles())
                                            .build();

	    Cell planyCell = plantCellBuilder.addCore(new Core())
                                            .addCellWall(new CellWall())
                                            .addCellMembrane(new CellMembrane())
                                            .addCytoplasm(new Cytoplasm())
                                            .build();
    }
}
