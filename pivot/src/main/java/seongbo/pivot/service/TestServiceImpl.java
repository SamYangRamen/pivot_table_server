package seongbo.pivot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seongbo.pivot.DAO.entity.TestTableEntity;
import seongbo.pivot.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {

  TestRepository testRepository;

  @Autowired
  public TestServiceImpl(TestRepository testRepository) {
    this.testRepository = testRepository;
  }

  @Override
  public void insertTestData(String str) {
    testRepository.save(new TestTableEntity(testRepository.max()+1, str));
  }
}
