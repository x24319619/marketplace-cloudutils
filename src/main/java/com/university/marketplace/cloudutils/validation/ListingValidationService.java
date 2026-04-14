package com.university.marketplace.cloudutils.validation;

public class ListingValidationService {

    public ValidationResult validate(String title,
                                     String description,
                                     Double price,
                                     String type,
                                     String productType) {
        ValidationResult titleResult = validateTitle(title);
        if (!titleResult.isValid()) {
            return titleResult;
        }

        ValidationResult descriptionResult = validateDescription(description);
        if (!descriptionResult.isValid()) {
            return descriptionResult;
        }

        ValidationResult priceResult = validatePrice(price);
        if (!priceResult.isValid()) {
            return priceResult;
        }

        return validateCategory(type, productType);
    }

    public ValidationResult validatePrice(Double price) {
        if (price == null || price < 0) {
            return new ValidationResult(false, "Listing price must be zero or greater");
        }
        return new ValidationResult(true, "Price accepted");
    }

    public ValidationResult validateTitle(String title) {
        if (title == null || title.isBlank()) {
            return new ValidationResult(false, "Listing title is required");
        }
        if (title.trim().length() < 3) {
            return new ValidationResult(false, "Listing title must be at least 3 characters");
        }
        return new ValidationResult(true, "Title accepted");
    }

    public ValidationResult validateDescription(String description) {
        if (description == null || description.isBlank()) {
            return new ValidationResult(false, "Listing description is required");
        }
        if (description.trim().length() < 10) {
            return new ValidationResult(false, "Listing description must be at least 10 characters");
        }
        return new ValidationResult(true, "Description accepted");
    }

    public ValidationResult validateCategory(String type, String productType) {
        if ((type == null || type.isBlank()) && (productType == null || productType.isBlank())) {
            return new ValidationResult(false, "Listing type or product category is required");
        }
        return new ValidationResult(true, "Category accepted");
    }
}
