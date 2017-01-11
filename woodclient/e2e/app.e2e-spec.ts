import { WoodclientPage } from './app.po';

describe('woodclient App', function() {
  let page: WoodclientPage;

  beforeEach(() => {
    page = new WoodclientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
