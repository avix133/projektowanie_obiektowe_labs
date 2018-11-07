package com.company;

import com.company.organella.Organella;
import com.company.organella.impl.*;

import java.util.ArrayList;
import java.util.List;

public abstract class CellBuilder<T extends CellBuilder<T>> {
    Core core;
    List<Organella> organellaList;

    CellBuilder() {
        this.organellaList = new ArrayList<>();
    }

    public T addCore(Core core) {
        if (this.core == null)
            this.core = core;
        else
            throw new IllegalStateException("There can be only one core specified!");
        return (T)this;
    }

    public T addCellMembrane(CellMembrane organella) {
        return addOrganella(organella);
    }

    public T addCoreMembrane(CoreMembrane organella) {
        return addOrganella(organella);
    }

    public T addCytoplasm(Cytoplasm organella) {
        return addOrganella(organella);
    }

    public T addEndoplasmicReticulum(EndoplasmicReticulum organella) {
        return addOrganella(organella);
    }

    public T addRibosome(Ribosome organella) {
        return addOrganella(organella);
    }

    public T addMitochondrion(Mitochondrion organella) {
        return addOrganella(organella);
    }

    public T addVacuoles(Vacuoles organella) {
        return addOrganella(organella);
    }

    public T addLysosome(Lysosome organella) {
        return addOrganella(organella);
    }

    public abstract Cell build();

    T addOrganella(Organella organella) {
        organellaList.add(organella);
        return (T)this;
    }
}
