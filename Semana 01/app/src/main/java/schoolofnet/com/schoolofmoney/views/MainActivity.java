package schoolofnet.com.schoolofmoney.views;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

import schoolofnet.com.schoolofmoney.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private FloatingActionButton fabMain, fabExpenses, fabEarning;
    private boolean fabsHide = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Carregando fragmento principal
            getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.fragmentContainer, new MainFragment()).
                    commit();

           // Carregar os FABS
                fabMain = findViewById(R.id.fabMain);
                fabMain.setOnClickListener(this);

                fabExpenses = findViewById(R.id.fabExpenses);
                fabExpenses.setOnClickListener(this);

                fabEarning = findViewById(R.id.fabEarnings);
    }

    @Override
    public void onClick(View view) {
        // A cada vez que eu clicar no FAB Principal chame o método show hide;
        if(view.getId() == R.id.fabMain){
            showHideFabs();
        }else if(view.getId() == R.id.fabExpenses){
            loadExpenseForm();
        }
    }

    private void loadExpenseForm(){
        // Carregando fragmento principal
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragmentContainer, new ExpenseFormFragment()).
                commit();
    }
    private void showHideFabs(){

        // Define a animação
            // 0 significa invisivel e 1 visivel
            // Indo de 0 a 1
        AlphaAnimation fadeAnimation = new AlphaAnimation(0,1);
        // Define a duração
        fadeAnimation.setDuration(1000);
        // Define o atraso
        fadeAnimation.setStartOffset(100);

        if(fabsHide){
            fabExpenses.setVisibility(View.VISIBLE);
            fabEarning.setVisibility(View.VISIBLE);
            fabExpenses.setAnimation(fadeAnimation);
            fabEarning.setAnimation(fadeAnimation);
        }else{
            fabExpenses.clearAnimation();
            fabEarning.clearAnimation();
            fabExpenses.setVisibility(View.INVISIBLE);
            fabEarning.setVisibility(View.INVISIBLE);
        }

        fabsHide = !fabsHide;
    }
}
