package coatocl.exaatocl.nestedsimplerecyclerview;

import java.util.List;

public class ParentItem
{
    private final String ParentItemTitle;
    private final List<ChildItem> ChildItemList;

    public ParentItem(String ParentItemTitle, List<ChildItem> ChildItemList)
    {

        this.ParentItemTitle = ParentItemTitle;
        this.ChildItemList = ChildItemList;
    }

    public String getParentItemTitle()
    {
        return ParentItemTitle;
    }

    public List<ChildItem> getChildItemList()
    {
        return ChildItemList;
    }

}
