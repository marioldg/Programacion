import java.util.ArrayList;

public class Ganaderia {
    private ArrayList<Vaca> vacas;

    public Ganaderia(ArrayList<Vaca> vacas) {
        this.vacas = vacas;
    }

    public String masLeche() {
        if (vacas.size() <= 0) {
            return null;
        } else {
            Vaca masLeche = vacas.get(0);
            for (Vaca i : vacas) {
                if (i.getLeche() >= masLeche.getLeche()) {
                    masLeche = i;
                }
            }
            return masLeche.getNombre();
        }
    }


    public String masPeso() {
        if (vacas.size() <= 0) {
            return null;
        } else {
            Vaca masLeche = vacas.get(0);
            for (Vaca i : vacas) {
                if (i.getPeso() >= masLeche.getPeso()) {
                    masLeche = i;
                }
            }
            return masLeche.getNombre();
        }
    }

    public String masTalla() {
        if (vacas.size() <= 0) {
            return null;
        } else {
            Vaca masLeche = vacas.get(0);
            for (Vaca i : vacas) {
                if (i.getTalla() >= masLeche.getTalla()) {
                    masLeche = i;
                }
            }
            return masLeche.getNombre();
        }

    }

    public String masLechePesoTalla() {
        if (vacas.size() <= 0) {
            return null;
        } else {
            Vaca ret = vacas.get(0);
            for (Vaca i : vacas) {
                if (i.getLeche() > ret.getLeche()) {
                    ret = i;
                } else if (i.getLeche() == ret.getLeche() && i.getPeso() > ret.getPeso()) {
                    ret = i;
                } else if (i.getLeche() == ret.getLeche() && i.getPeso() == ret.getPeso() && i.getTalla() > ret.getTalla()) {
                    ret = i;
                }
            }
            return ret.getNombre();
        }
    }

    public String masConTopes(int topeLeche, int topePeso, int topeTalla) {
        if (vacas.size() <= 0) {
            return null;
        } else {
            boolean empatadasLeche = false;
            boolean empatadasPeso = false;
            boolean empatadasTalla = false;
            Vaca ret = vacas.get(0);
            for (Vaca i : vacas) {

                /**
                 * SI SUPEERAN EL TOPE
                 * SETEO EL TOPE
                 */
                if (i.getLeche() > topeLeche) {
                    i.setLeche(topeLeche);

                } else if (ret.getLeche() > topeLeche) {
                    ret.setLeche(topeLeche);
                }

                if (i.getPeso() > topePeso) {
                    i.setPeso(topePeso);
                }

                if (ret.getPeso() > topePeso) {
                    ret.setPeso(topePeso);
                }

                if (i.getTalla() > topeTalla) {
                    i.setTalla(topeTalla);
                }

                if (ret.getTalla() > topeTalla) {
                    ret.setTalla(topeTalla);
                }

                /**
                 * SI MISMA LECHE BOOLEAN TRUE,
                 * SINO GANA MAX LECHE
                 */
                if (i.getLeche() == ret.getLeche()) {
                    empatadasLeche = true;
                } else if (i.getLeche() > ret.getLeche()) {
                    ret = i;
                }

                /**
                 * SI MISMA LECHE Y PESO BOOLEAN TRUE,
                 * SINO GANA MAX PESO
                 */

                if (empatadasLeche) {
                    if (i.getPeso() == ret.getPeso()) {
                        empatadasPeso = true;
                    } else if (i.getPeso() > ret.getPeso()) {
                        ret = i;
                    }

                    /**
                     * SI MISMO PESO,
                     * SINO GANA MAX TALLA
                     */

                    if (empatadasPeso) {
                        if (i.getTalla() == ret.getTalla()) {
                            empatadasTalla=true;
                        }


                        if(empatadasTalla){
                            return masLechePesoTalla();
                        }else if (i.getTalla() > ret.getTalla()) {
                            ret = i;
                        }
                    }
                }

            }
            return ret.getNombre();
        }
    }
}