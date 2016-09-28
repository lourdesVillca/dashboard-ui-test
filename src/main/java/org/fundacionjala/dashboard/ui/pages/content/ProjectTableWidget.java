package org.fundacionjala.dashboard.ui.pages.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.utils.Utils;

/**
 * Manage Project table Widget page.
 */
public class ProjectTableWidget extends AbstractBasePage{
    @FindBy(xpath = "//table[@class='ui celled dash table table-widget sortable']")
    private WebElement projectTable;

    /**
     * Method to get the table for projects.
     *
     * @return a Map with the information of the features.project table.
     */
    public final Map<String, String> getProjectTable() {
        Map<String, String> result = new HashMap<>();
        List<WebElement> projectTableHeader = projectTable.findElements(By.tagName("th"));
        List<WebElement> projectTableRow = projectTable.findElements(By.cssSelector("tbody>tr>td"));

        for (int i = 0; i < projectTableRow.size(); i++) {
            String key = Utils.replaceSpaceWithUnderscore(projectTableHeader.get(i).getText());
            result.put(key, projectTableRow.get(i).getText());
        }
        return result;
    }

}

