package com.itlize.project.resourceManagement.Entity;

import javax.persistence.*;
import java.util.concurrent.CountDownLatch;
@Entity
public class ProjectColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_column_id")
    private Integer id;
    @Column(name = "project_id")
    private Integer projectId;
    @Column(name = "column_name")
    private String columnName;
    @Column(name = "project_column_type")
    private ColumnType type;
    @Column(name = "formula_text")
    private String formulaText;

    public ProjectColumn() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnType getType() {
        return type;
    }

    public void setType(ColumnType type) {
        this.type = type;
    }

    public String getFormulaText() {
        return formulaText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
    }

    @Override
    public String toString() {
        return "ProjectColumn{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", columnName='" + columnName + '\'' +
                ", type=" + type +
                ", formulaText='" + formulaText + '\'' +
                '}';
    }
}
