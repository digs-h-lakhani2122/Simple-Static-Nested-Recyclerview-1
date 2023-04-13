package coatocl.exaatocl.nestedsimplerecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentItemAdapter extends RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder> {

    private final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private final List<ParentItem> itemList;

    ParentItemAdapter(List<ParentItem> itemList)
    {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_item, viewGroup, false);

        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder parentViewHolder, int position)
    {

        ParentItem parentItem = itemList.get(position);

        parentViewHolder.ParentItemTitle.setText(parentItem.getParentItemTitle());

        LinearLayoutManager layoutManager = new LinearLayoutManager(parentViewHolder.ChildRecyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false);

        layoutManager.setInitialPrefetchItemCount(parentItem.getChildItemList().size());

        ChildAdapter childItemAdapter = new ChildAdapter(parentItem.getChildItemList());
        parentViewHolder.ChildRecyclerView.setLayoutManager(layoutManager);
        parentViewHolder.ChildRecyclerView.setAdapter(childItemAdapter);
        parentViewHolder.ChildRecyclerView.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount()
    {

        return itemList.size();
    }

    static class ParentViewHolder extends RecyclerView.ViewHolder {

        private final TextView ParentItemTitle;
        private final RecyclerView ChildRecyclerView;

        ParentViewHolder(final View itemView)
        {
            super(itemView);

            ParentItemTitle = itemView.findViewById(R.id.parent_item_title);
            ChildRecyclerView = itemView.findViewById(R.id.child_recyclerview);
        }
    }
}
