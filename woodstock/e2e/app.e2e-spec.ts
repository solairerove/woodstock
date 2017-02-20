import { WoodstockPage } from './app.po';

describe('woodstock App', function() {
  let page: WoodstockPage;

  beforeEach(() => {
    page = new WoodstockPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
