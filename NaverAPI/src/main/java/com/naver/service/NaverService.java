package com.naver.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.naver.domain.LogTable;
import com.naver.domain.PoolA;
import com.naver.domain.PoolB;
import com.naver.domain.PoolC;
import com.naver.domain.PoolD;
import com.naver.domain.PoolE;
import com.naver.domain.PoolF;
import com.naver.domain.PoolG;
import com.naver.domain.PoolH;
import com.naver.domain.PoolI;
import com.naver.domain.PoolJ;
import com.naver.domain.PoolL;
import com.naver.domain.PoolM;
import com.naver.domain.PoolN;
import com.naver.domain.PoolO;
import com.naver.domain.PoolP;
import com.naver.domain.PoolQ;
import com.naver.domain.PoolS;
import com.naver.domain.PoolT;
import com.naver.domain.PoolU;
import com.naver.domain.PoolV;
import com.naver.domain.PoolW;
import com.naver.persistence.ARepository;
import com.naver.persistence.BRepository;
import com.naver.persistence.CRepository;
import com.naver.persistence.DRepository;
import com.naver.persistence.ERepository;
import com.naver.persistence.FRepository;
import com.naver.persistence.GRepository;
import com.naver.persistence.HRepository;
import com.naver.persistence.IRepository;
import com.naver.persistence.JRepository;
import com.naver.persistence.LRepository;
import com.naver.persistence.LogRepository;
import com.naver.persistence.MRepository;
import com.naver.persistence.NRepository;
import com.naver.persistence.ORepository;
import com.naver.persistence.PRepository;
import com.naver.persistence.QRepository;
import com.naver.persistence.SRepository;
import com.naver.persistence.TRepository;
import com.naver.persistence.URepository;
import com.naver.persistence.VRepository;
import com.naver.persistence.WRepository;

@Service
public class NaverService {

	@Autowired
	private LogRepository logRepo;

	@Autowired
	private ARepository aRepo;

	@Autowired
	private BRepository bRepo;

	@Autowired
	private CRepository cRepo;

	@Autowired
	private DRepository dRepo;

	@Autowired
	private ERepository eRepo;

	@Autowired
	private FRepository fRepo;

	@Autowired
	private GRepository gRepo;

	@Autowired
	private HRepository hRepo;

	@Autowired
	private IRepository iRepo;

	@Autowired
	private JRepository jRepo;

	@Autowired
	private LRepository lRepo;

	@Autowired
	private MRepository mRepo;

	@Autowired
	private NRepository nRepo;

	@Autowired
	private ORepository oRepo;

	@Autowired
	private PRepository pRepo;

	@Autowired
	private QRepository qRepo;

	@Autowired
	private SRepository sRepo;

	@Autowired
	private TRepository tRepo;

	@Autowired
	private URepository uRepo;

	@Autowired
	private VRepository vRepo;

	@Autowired
	private WRepository wRepo;

	@Autowired
	private RestTemplate restTemplate;

	public String getValuesAndSendToFlask(String pool, LocalDateTime date) {

		Pageable previousDataPageable = PageRequest.of(0, 144, Sort.by("dateTime").descending());
		Pageable nextDataPageable = PageRequest.of(0, 144, Sort.by("dateTime"));

		List<PoolA> aValues = new ArrayList<>();
		List<PoolB> bValues = new ArrayList<>();
		List<PoolC> cValues = new ArrayList<>();
		List<PoolD> dValues = new ArrayList<>();
		List<PoolE> eValues = new ArrayList<>();
		List<PoolF> fValues = new ArrayList<>();
		List<PoolG> gValues = new ArrayList<>();
		List<PoolH> hValues = new ArrayList<>();
		List<PoolI> iValues = new ArrayList<>();
		List<PoolJ> jValues = new ArrayList<>();
		List<PoolL> lValues = new ArrayList<>();
		List<PoolM> mValues = new ArrayList<>();
		List<PoolN> nValues = new ArrayList<>();
		List<PoolO> oValues = new ArrayList<>();
		List<PoolP> pValues = new ArrayList<>();
		List<PoolQ> qValues = new ArrayList<>();
		List<PoolS> sValues = new ArrayList<>();
		List<PoolT> tValues = new ArrayList<>();
		List<PoolU> uValues = new ArrayList<>();
		List<PoolV> vValues = new ArrayList<>();
		List<PoolW> wValues = new ArrayList<>();

		Map<String, Object> requestData = new HashMap<>();

		if (pool.equals("A")) {
			List<PoolA> beforeData = aRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolA> fromData = aRepo.findFromDate(date, nextDataPageable);

			aValues.addAll(beforeData);
			aValues.addAll(fromData);

			requestData.put("values", aValues);
		} else if (pool.equals("B")) {
			List<PoolB> beforeData = bRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolB> fromData = bRepo.findFromDate(date, nextDataPageable);

			bValues.addAll(beforeData);
			bValues.addAll(fromData);

			requestData.put("values", bValues);
		} else if (pool.equals("C")) {
			List<PoolC> beforeData = cRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolC> fromData = cRepo.findFromDate(date, nextDataPageable);

			cValues.addAll(beforeData);
			cValues.addAll(fromData);

			requestData.put("values", cValues);
		} else if (pool.equals("D")) {
			List<PoolD> beforeData = dRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolD> fromData = dRepo.findFromDate(date, nextDataPageable);

			dValues.addAll(beforeData);
			dValues.addAll(fromData);

			requestData.put("values", dValues);
		} else if (pool.equals("E")) {
			List<PoolE> beforeData = eRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolE> fromData = eRepo.findFromDate(date, nextDataPageable);

			eValues.addAll(beforeData);
			eValues.addAll(fromData);

			requestData.put("values", eValues);
		} else if (pool.equals("F")) {
			List<PoolF> beforeData = fRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolF> fromData = fRepo.findFromDate(date, nextDataPageable);

			fValues.addAll(beforeData);
			fValues.addAll(fromData);

			requestData.put("values", fValues);
		} else if (pool.equals("G")) {
			List<PoolG> beforeData = gRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolG> fromData = gRepo.findFromDate(date, nextDataPageable);

			gValues.addAll(beforeData);
			gValues.addAll(fromData);

			requestData.put("values", gValues);
		} else if (pool.equals("J")) {
			List<PoolJ> beforeData = jRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolJ> fromData = jRepo.findFromDate(date, nextDataPageable);

			jValues.addAll(beforeData);
			jValues.addAll(fromData);

			requestData.put("values", jValues);
		} else if (pool.equals("L")) {
			List<PoolL> beforeData = lRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolL> fromData = lRepo.findFromDate(date, nextDataPageable);

			lValues.addAll(beforeData);
			lValues.addAll(fromData);

			requestData.put("values", lValues);
		} else if (pool.equals("M")) {
			List<PoolM> beforeData = mRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolM> fromData = mRepo.findFromDate(date, nextDataPageable);

			mValues.addAll(beforeData);
			mValues.addAll(fromData);

			requestData.put("values", mValues);
		} else if (pool.equals("N")) {
			List<PoolN> beforeData = nRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolN> fromData = nRepo.findFromDate(date, nextDataPageable);

			nValues.addAll(beforeData);
			nValues.addAll(fromData);

			requestData.put("values", nValues);
		} else if (pool.equals("O")) {
			List<PoolO> beforeData = oRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolO> fromData = oRepo.findFromDate(date, nextDataPageable);

			oValues.addAll(beforeData);
			oValues.addAll(fromData);

			requestData.put("values", oValues);
		} else if (pool.equals("P")) {
			List<PoolP> beforeData = pRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolP> fromData = pRepo.findFromDate(date, nextDataPageable);

			pValues.addAll(beforeData);
			pValues.addAll(fromData);

			requestData.put("values", pValues);
		} else if (pool.equals("Q")) {
			List<PoolQ> beforeData = qRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolQ> fromData = qRepo.findFromDate(date, nextDataPageable);

			qValues.addAll(beforeData);
			qValues.addAll(fromData);

			requestData.put("values", qValues);
		} else if (pool.equals("S")) {
			List<PoolS> beforeData = sRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolS> fromData = sRepo.findFromDate(date, nextDataPageable);

			sValues.addAll(beforeData);
			sValues.addAll(fromData);

			requestData.put("values", sValues);
		} else if (pool.equals("T")) {
			List<PoolT> beforeData = tRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolT> fromData = tRepo.findFromDate(date, nextDataPageable);

			tValues.addAll(beforeData);
			tValues.addAll(fromData);

			requestData.put("values", tValues);
		} else if (pool.equals("U")) {
			List<PoolU> beforeData = uRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolU> fromData = uRepo.findFromDate(date, nextDataPageable);

			uValues.addAll(beforeData);
			uValues.addAll(fromData);

			requestData.put("values", uValues);
		} else if (pool.equals("V")) {
			List<PoolV> beforeData = vRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolV> fromData = vRepo.findFromDate(date, nextDataPageable);

			vValues.addAll(beforeData);
			vValues.addAll(fromData);

			requestData.put("values", vValues);
		} else if (pool.equals("W")) {
			List<PoolW> beforeData = wRepo.findBeforeDate(date, previousDataPageable);

			// 역정렬된 데이터를 오름차순으로 재정렬
			Collections.reverse(beforeData);

			List<PoolW> fromData = wRepo.findFromDate(date, nextDataPageable);

			wValues.addAll(beforeData);
			wValues.addAll(fromData);

			requestData.put("values", wValues);
		} else {
			return "error";
		}

		// Flask 서버의 URL
		String flaskUrl = "http://localhost:5000/predict";

		// 전송할 데이터 맵 생성
		requestData.put("pool", pool);

		// Flask 서버로 데이터 전송 후 결과 반환
		return restTemplate.postForObject(flaskUrl, requestData, String.class);
	}

	public List<LogTable> getLog() {
		return logRepo.findAll();
	}

	public String setLog(LogTable log) {
		try {
			logRepo.save(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
}
