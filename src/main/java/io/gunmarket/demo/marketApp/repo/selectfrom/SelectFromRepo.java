package io.gunmarket.demo.marketApp.repo.selectfrom;

import java.util.List;

public interface SelectFromRepo {

    List<String> selectFrom(String column, String table);

}
