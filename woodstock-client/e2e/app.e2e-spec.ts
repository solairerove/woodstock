import { WoodstockClientPage } from './app.po';

describe('woodstock-client App', function() {
  let page: WoodstockClientPage;

  beforeEach(() => {
    page = new WoodstockClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
