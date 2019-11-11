const URL = 'http://localhost:8081';
let entries = [];
let categories = [];
let jobs = [];

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};

const createEntry = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entry = {};
    entry['checkIn'] = dateAndTimeToDate(formData.get('checkInDate'), formData.get('checkInTime'));
    entry['checkOut'] = dateAndTimeToDate(formData.get('checkOutDate'), formData.get('checkOutTime'));

    fetch(`${URL}/entries`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        result.json().then((entry) => {
            entries.push(entry);
            renderEntries();
        });
    });
};

const createCategory = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const category = {};
    category['name'] = formData.get('category');

    fetch(`${URL}/categories`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(category)
    }).then((result) => {
        result.json().then((category) => {
            categories.push(category);
            renderCategories();
        })
    });
};

const createJob = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const job = {};
    job['name'] = formData.get('job');

    fetch(`${URL}/jobs`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(job)
    }).then((result) => {
        result.json().then((job) => {
            categories.push(job);
            renderJobs();
        })
    });
};

const indexEntries = () => {
    fetch(`${URL}/entries`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderEntries();
        });
    });
    renderEntries();
};

const indexCategories = () => {
    fetch(`${URL}/categories`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderCategories();
        });
    });
    renderCategories();
};

const indexJobs = () => {
    fetch(`${URL}/jobs`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderJobs();
        });
    });
    renderJobs();
};

const indexEntities = () => {
    indexEntries();
    indexCategories();
    indexJobs();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderEntries = () => {
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    entries.forEach((entry) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(entry.id));
        row.appendChild(createCell(new Date(entry.checkIn).toLocaleString()));
        row.appendChild(createCell(new Date(entry.checkOut).toLocaleString()));
        row.append(createCell(entry.categoryId));
        display.appendChild(row);
    });
};

const renderCategories = () => {
    const display = document.querySelector('#categoryDisplay');
    display.innerHTML = '';
    categories.forEach((category) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(category.id));
        row.appendChild(createCell(category.name));
        display.appendChild(row);
    });
};

const renderJobs = () => {
    const display = document.querySelector('#jobDisplay');
    display.innerHTML = '';
    jobs.forEach((job) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(job.id));
        row.appendChild(createCell(job.name));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function () {
    const createEntryForm = document.querySelector('#createEntryForm');
    const createCategoryForm = document.querySelector('#createCategoryForm');
    const createJobForm = document.querySelector('#createJobForm');
    createEntryForm.addEventListener('submit', createEntry);
    createCategoryForm.addEventListener('submit', createCategory);
    createJobForm.addEventListener('submit', createJob);
    indexEntities();
});