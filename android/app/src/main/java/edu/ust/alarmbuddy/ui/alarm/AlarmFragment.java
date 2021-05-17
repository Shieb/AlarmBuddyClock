package edu.ust.alarmbuddy.ui.alarm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import edu.ust.alarmbuddy.R;
import edu.ust.alarmbuddy.ui.alarms.database.Alarm;

import java.util.Random;

public class AlarmFragment extends Fragment {

	private AlarmViewModel alarmViewModel;
	private static Random random;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		alarmViewModel = ViewModelProviders.of(this).get(AlarmViewModel.class);
		random = new Random();
	}


	public View onCreateView(@NonNull LayoutInflater inflater,
		ViewGroup container, Bundle savedInstanceState) {

		AlarmViewModel alarmViewModel = new ViewModelProvider(this).get(AlarmViewModel.class);
		View root = inflater.inflate(R.layout.fragment_alarm, container, false);

		final Button button = root.findViewById(R.id.fragment_alarm_createAlarm);
		button.setOnClickListener(view -> {
			final TimePicker timePicker = root.findViewById(R.id.fragment_alarm_clock);
			int alarmID = random.nextInt(Integer.MAX_VALUE);
			final TextView alarmName = root.findViewById(R.id.fragment_alarm_alarmName);
			Alarm alarm = new Alarm(alarmID, timePicker.getHour(), timePicker.getMinute(), false,
				false, false, false, false, false, false, alarmName.getText().toString(),
				System.currentTimeMillis(), true);
//            alarmViewModel.insert(alarm);

			alarm.setAlarm(getContext());
		});
		return root;
	}
}