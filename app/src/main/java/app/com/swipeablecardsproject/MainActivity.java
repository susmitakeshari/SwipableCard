package app.com.swipeablecardsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.daprlabs.cardstack.SwipeDeck;

import app.com.swipeablecardsproject.adapter.SwipeAbleCardAdapter;
import app.com.swipeablecardsproject.databinding.ActivityMainBinding;
import app.com.swipeablecardsproject.ui.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainActivityViewModel viewModel;
    SwipeAbleCardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.init();
        getCardList();
        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtProgressCount.setVisibility(View.VISIBLE);
                binding.progressBar.setVisibility(View.VISIBLE);
               getCardList();
            }
        });

        binding.swipeCard.setEventCallback(new SwipeDeck.SwipeEventCallback() {
            @Override
            public void cardSwipedLeft(int position) {
                int selectedIndex = position <= 0 ? 0: position-1;
                int currentProgress = binding.progressBar.getProgress();
                int maxProgress = binding.progressBar.getMax();
                int progress = currentProgress == maxProgress ? currentProgress : currentProgress +1;
                binding.swipeCard.setSelection(selectedIndex);
                binding.progressBar.setProgress(progress);
                binding.txtProgressCount.setText(String.valueOf(progress)+"/"+String.valueOf(maxProgress));
            }

            @Override
            public void cardSwipedRight(int position) {
                int currentProgress = binding.progressBar.getProgress();
                int maxProgress  = binding.progressBar.getMax();
                int progress = currentProgress -1;
                binding.progressBar.setProgress(progress);
                binding.txtProgressCount.setText(String.valueOf(progress)+"/"+String.valueOf(maxProgress));
            }

            @Override
            public void cardsDepleted() {
                binding.txtProgressCount.setVisibility(View.GONE);
                binding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void cardActionDown() {
            }

            @Override
            public void cardActionUp() {
            }
        });
    }
    public void getCardList(){
        viewModel.getCardResponseLiveData().observe(this,cardResponses -> {
            if(cardResponses!=null){
                adapter = new SwipeAbleCardAdapter(cardResponses.getCardList(), this);
                int size = cardResponses.getCardList().size();
                binding.progressBar.setMax(size);
                binding.progressBar.setProgress(size);
                binding.txtProgressCount.setText(String.valueOf(size)+"/"+String.valueOf(size));
                binding.swipeCard.setAdapter(adapter);
            }
        });
    }
}