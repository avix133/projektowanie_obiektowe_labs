package com.company;

import com.company.organella.Organella;

import java.util.List;

class Cell {
    private CellType cellType;
    private List<Organella> organellaList;

    public Cell(CellType cellType, List<Organella> organellaList) {
        this.cellType = cellType;
        this.organellaList = organellaList;
    }

    public CellType getCellType() {

        return cellType;
    }

    void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public List<Organella> getOrganellaList() {
        return organellaList;
    }

    void setOrganellaList(List<Organella> organellaList) {
        this.organellaList = organellaList;
    }
}
