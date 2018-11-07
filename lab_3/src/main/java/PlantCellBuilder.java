package com.company;

import com.company.organella.impl.CellWall;
import com.company.organella.impl.Chloroplast;

public class PlantCellBuilder extends CellBuilder<PlantCellBuilder> {

    private CellWall cellWall;

    public CellBuilder addCellWall(CellWall organella) {
        if (cellWall == null)
            cellWall = organella;
        else
            throw new IllegalStateException("There can be only one cell wall specified!");
        this.addOrganella(cellWall);
        return this;
    }

    public CellBuilder addChloroplast(Chloroplast organella) {
        return this.addOrganella(organella);
    }
    @Override
    public Cell build() {
        return new Cell(CellType.PLANT, this.organellaList);
    }
}
