package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;
    @Override
    public double calcul() {
        double tmp= dao.getData();
        return 0;
    }


    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
