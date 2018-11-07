package com.company;

public class AnimalCellBuilder extends CellBuilder<AnimalCellBuilder> {
    @Override
    public Cell build() {
        return new Cell(CellType.ANIMAL, this.organellaList);
    }
}
