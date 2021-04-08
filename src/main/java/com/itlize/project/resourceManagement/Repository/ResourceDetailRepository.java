package com.itlize.project.resourceManagement.Repository;


import com.itlize.project.resourceManagement.Entity.ResourceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceDetailRepository extends JpaRepository<ResourceDetail,Integer> {

    List<ResourceDetail> findByResource(Integer resourceId);
}
