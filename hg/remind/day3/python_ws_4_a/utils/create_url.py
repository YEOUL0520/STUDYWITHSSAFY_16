def create_url(name, main_url, page_num=1):
    new_url = f'{main_url}/{name}?page={page_num}'
    return new_url