package com.southwind.mapper;

import com.southwind.entity.Moveout;
import java.util.List;

/**
 * @author lzk
 * @create 2022-07-06 12:53
 */
public interface MoveoutMapper {
    public void saveMoveout(Moveout moveout);

    public List<Moveout> list();

    public List<Moveout> searchByStudentName(String value);

    public List<Moveout> searchByDormitoryName(String value);
}

