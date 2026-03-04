package product_service.demo.Request;

public class UpdateCategoryRequest {
    private String name;
    private String slug;
    private String description;
    private Long parentId;
    private Integer sortOrder;
    private Boolean isActive;

    public UpdateCategoryRequest() {}

    public UpdateCategoryRequest(String name, String slug, String description,
                                 Long parentId, Integer sortOrder, Boolean isActive) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.parentId = parentId;
        this.sortOrder = sortOrder;
        this.isActive = isActive;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}