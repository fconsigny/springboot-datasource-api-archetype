package com.fconsigny.springboot.datasource.api.archetype;


import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface DatasourceOperation {

}
