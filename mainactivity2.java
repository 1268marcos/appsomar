
/**
 *
 * Creative Commons (CC) 2019 Marcos Vinícius da Silva Santos and Marcos Antonio dos Santos
 *
 * Licensed under the Creative Commons, Version 4.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://creativecommons.org/licenses/by-nc-sa/4.0/
 *    https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode
 *    Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 *
 *    https://creativecommons.org/licenses/by-nc-sa/4.0/deed.pt_BR
 *    https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode.pt
 *    Atribuição-NãoComercial-CompartilhaIgual 4.0 Internacional (CC BY-NC-SA 4.0)
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

package com.example.somardoisnumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditNum1, mEditNum2;
    private TextView mTextResult;
    private Button mButtonSum, mButtonClean, mButtonSub;

    private void newSum(){
        if(TextUtils.isEmpty(mEditNum1.getText().toString()) ||
            TextUtils.isEmpty(mEditNum2.getText().toString())) {
            Toast.makeText(this, "Ops Erro", Toast.LENGTH_SHORT).show();
            return;
        } else {
            double num1 = Double.parseDouble(mEditNum1.getText().toString());
            double num2 = Double.parseDouble(mEditNum2.getText().toString());
            mTextResult.setText(Double.toString(num1+num2));
        }
    }

    private void newSub(){
        if(TextUtils.isEmpty(mEditNum1.getText().toString())
        || TextUtils.isEmpty(mEditNum2.getText().toString())) {
            Toast.makeText(this, "ops", Toast.LENGTH_SHORT).show();
            return;
        } else {
            double num1 = Double.parseDouble(mEditNum1.getText().toString());
            double num2 = Double.parseDouble(mEditNum2.getText().toString());
            mTextResult.setText(Double.toString(num1-num2));

        }


    }




    private void cleanEntrace(){
        mTextResult.setText("");
        mEditNum1.setText("");
        mEditNum2.setText("");
    }

    public class NewSumClick implements View.OnClickListener{
        @Override
        public void onClick(View view){
            newSum();
        }
    }

    public class NewSubClick implements View.OnClickListener{
        @Override
        public void onClick(View view){
            newSub();
        }
    }


    public class CleanClick implements  View.OnClickListener{
        @Override
        public void onClick(View view){
            cleanEntrace();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextResult = findViewById(R.id.textViewResult);

        mEditNum1 = findViewById(R.id.editTextNumber1);

       mEditNum2 = findViewById(R.id.editTextNumber2);

       mButtonSum = findViewById(R.id.buttonSum);
       mButtonSum.setOnClickListener(new NewSumClick());

       mButtonClean = findViewById(R.id.buttonClean);
       mButtonClean.setOnClickListener(new CleanClick());

       mButtonSub = findViewById(R.id.buttonSubtract);
       mButtonSub.setOnClickListener(new NewSubClick());

    }
}
